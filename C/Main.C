#include <stdio.h>

int main()
{
	int x;
	int* pointer;
	pointer = &x;
	*pointer = 20;
	*pointer = 40;
	//pointer -= 1;
	printf("%d", *pointer - 1);
}