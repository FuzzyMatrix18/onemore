#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_SIZE 100
struct Stack
{
    int top;
    char array[MAX_SIZE];
};
int operator(char ch)
{
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}
int precedence(char ch) 
{
    switch(ch)
    {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}
void push(struct Stack* stack, char value) 
{
    if (stack->top == MAX_SIZE - 1) 
    {
        printf("Stack Overflow\n");
        exit(EXIT_FAILURE);
    }
    stack->array[++stack->top] = value;
}
char pop(struct Stack* stack)
 {
    if (stack->top == -1) 
    {
        printf("Stack Underflow\n");
        exit(EXIT_FAILURE);
    }
    return stack->array[stack->top--];
}
int empty(struct Stack* stack)
{
    return stack->top == -1;
}
char peek(struct Stack* stack) 
{
    return stack->array[stack->top];
}
void infixtoprefix(char infix[], char prefix[]) 
{
    struct Stack stack;
    stack.top = -1;
    int length = strlen(infix);
    char reversed[length + 1];
    for (int i = 0; i < length; i++) 
    {
        reversed[i] = infix[length - i - 1];
    }
    reversed[length] = '\0';
    
    int j = 0;
    for (int i = 0; i < length; i++) 
    {
        if (reversed[i] == '(') 
        {
            reversed[i] = ')';
            i++;
        } 
        else if (reversed[i] == ')') 
        {
            reversed[i] = '(';
            i++;
        }
    }
    for (int i = 0; i < length; i++) 
    {
        char ch = reversed[i];
        if (isalnum(ch))
        {
            prefix[j++] = ch;
        } 
        else if (ch == '(') 
        {
            push(&stack, ch);
        } 
        else if (ch == ')') 
        {
            while (!empty(&stack) && peek(&stack) != '(') 
            {
                prefix[j++] = pop(&stack);
            }
            pop(&stack); 
        }
         else if (operator(ch)) 
         {
            while (!empty(&stack) && precedence(peek(&stack)) > precedence(ch)) 
            {
                prefix[j++] = pop(&stack);
            }
            push(&stack, ch);
        }
    }  
    while (!empty(&stack)) 
    {
        prefix[j++] = pop(&stack);
    }
    prefix[j] = '\0';
    length = strlen(prefix);
    for (int i = 0; i < length / 2; i++) 
    {
        char temp = prefix[i];
        prefix[i] = prefix[length - i - 1];
        prefix[length - i - 1] = temp;
    }
}
int main() 
{
    char infix[MAX_SIZE];
    char prefix[MAX_SIZE];
    printf("Enter an infix expression: ");
    fgets(infix, sizeof(infix),stdin);
    infixtoprefix(infix, prefix);
    printf("Infix Expression: %s", infix);
    printf("Prefix Expression: %s\n", prefix);
    return 0;
}