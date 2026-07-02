
struct node
{
struct node *prev;
int data;
struct node *next;
};
struct node *head;
create()
{
    struct node *head = NULL;
    struct node *newnode,temp;
    newnode = (struct node *)malloc(sizeof(struct node));
    printf("Enter data :");
    scanf("%d",& head->data);
    newnode->prev=NULL;
    newnode->next= NULL;
    if(head==NULL)
    {
        head=newnode;
    }
    else
    {
        head ->next=newnode;
        newnode->prev=head;
        head ->next;
    }


}