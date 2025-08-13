
implementing the least frequently used cache

create a node->prev,tail,key,val,frequency
create doublyLinkedList->obj(tail,head,size),methods(insertAtHead(most 
frequent),removeNode(simply update the links),removeFromTail(least 
frequently used))

create the cache class->obj(keys->map,freq->map,minFreq,size(current no of 
elements),capacity(max 
elements it can hold)

get method->get the node with the help of the key,if there is no node return 
null ,otherwise update the frequency

update method->get the old frequency,remove it from freq map,if it was the 
least referred and size of freq list is zero update min frequency we have to 
update the node frequency if there is no node frequency means the list is empty 
create a new list at node frequency and insert it

set method-> get the node if there is none there are two possibilities if 
the list has space check if it first occurrence simply insert the node at the 
tail and update the 
frequency
and increment the size 
the second option is we have to delete to make space simply update the val 
and pass the node to the update method 