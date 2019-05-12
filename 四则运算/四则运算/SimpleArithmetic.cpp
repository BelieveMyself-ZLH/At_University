#include "SimpleArithmetic.h"
void main()
{
	while (1)
	{
		int num;
		WelcomeMenu();
		num = Menu();
		FunctionRealize(num);
		OverMenu();
		break;
	}
}

