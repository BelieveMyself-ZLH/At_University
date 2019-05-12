#include "SimpleArithmetic.h"
//菜单实现
int Menu()
{
	int a;
	printf("\n\n\n--------------------------------------------------------------------------------\n");
	printf("\t\t\t--------------------------------\n");
	printf("\t\t\t\t欢迎来到运算练习\n");
	printf("\t\t\t	1.加法运算\n");
	printf("\t\t\t	2.减法运算\n");
	printf("\t\t\t	3.乘法运算\n");
	printf("\t\t\t	4.除法运算\n");
	printf("\t\t\t	5.四则运算\n");
	printf("\t\t\t	0.退出\n");
	printf("\t\t\t--------------------------------\n");
	printf("\t\t\t请输入你的选项:");
	scanf_s("%d", &a);
	system("cls");
	return a;
}
//功能实现
void FunctionRealize(int num)
{
	switch (num)
	{
	case 1:
		ADD();
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	case 5:
		RandomArithmetic();
		break;
	case 0:
		exit(0);
		break;
	}
	system("cls");
}
//欢饮菜单
void WelcomeMenu()
{
	printf("\n\n\n————————————————————————————————————————\n");
	printf("\tWelcome to use four arithmetic questions to generate program\n");
	printf("\t\t\t欢迎使用四则运算题目生成程序\n");
	printf("\n\n\n                                                    This program made by ZLTiger\n");
	printf("————————————————————————————————————————\n");
	printf("please input any key to continue....\n");
	_getch();
	system("cls");
}
//结束菜单
void OverMenu()
{
	printf("\n\n\n★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	printf("\n\t\t感谢使用本程序，希望你的数学有个好的提升！\n");
	printf("\n\t\t\t如果你对本程序有什么建议，感谢你的提出!\n");
	printf("\n\n                                                            Author:ZLTiger\n");
	printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	printf("please input any key to continue...");
	_getch();
}


//选择四则运算
void ChoseArithmetic()
{}
//随机四则运算switch
void RandomArithmetic()
{
	srand((int)time(0));
	int a = 0, b = 0, Operator;
	char ch;
	a = random(range0);
	b = random(range0);
	Operator = random(range1);
	switch (Operator)
	{
	case 0:
		ch = '+';
		ModelOperation(a, b, ch);
		break;
	case 1:
		ch = '-';
		ModelOperation(a, b, ch);
		break;
	case 2:
		ch = '*';
		ModelOperation(a, b, ch);
		break;
	case 3:
		ch = '/';
		ModelOperation(a, b, ch);
		break;
	}
}
void Addition(int a, int b)		//  +
{
	printf("%d+%d=\n", a, b);
}
void Subtraction(int a, int b)		//  -
{
	printf("%d-%d=\n", a, b);
}
void Multiplication(int a, int b)	//  *
{
	printf("%d*%d=\n", a, b);
}
void Division(int a, int b)		//  /
{
	printf("%d/%d=\n", a, b);
}
//模板运算
void ModelOperation(int a, int b, char ch)
{
	float c, answer = 0;
	char yn;
	switch (ch)
	{
	case '+':
		c = a + b;
		break;
	case '-':
		c = a - b;
		break;
	case '*':
		c = a * b;
		break;
	case '/':
		c = a / b;
		break;
	}
	printf("\n\n\n————————————————————————————————————————\n");
	printf("%d%c%d=", a, ch, b);
	scanf_s("%f", &answer);
	if (answer == c)
	{
		printf("OK!That is right\n");
	}
	else
	{
		printf("Wrong!You shoule good learn\n");
	}
}
void ADD()
{
	HANDLE hout;
	COORD coord;//屏幕上的坐标
	int realize[100], user[100];
	int a, b, count = 1, u_ss = 0, u_count = 1;
	char ch;
	char ss[5];
	srand((int)time(0));
	hout = GetStdHandle(STD_OUTPUT_HANDLE);//从键盘获取输入，如果是方向键则执行方向功能，如果是回车键则换行，如果是字符则输出
	printf("答完题后按q键退出!\n");
	printf("--------------------------------------------------------------------------------");
	for (int i = 0; i < 50; i++)
	{
		a = random(range0);
		b = random(range0);
		realize[count] = a + b;
		count++;
		printf("%2d%c%2d=              ", a, '+', b);
	}
	coord.X = 6;
	coord.Y = 2;
	SetConsoleCursorPosition(hout, coord);
	while (1)
	{
		ch = _getch();
		if (ch == 'q')
		{
			break;
		}
		printf("%c", ch);
		if (ch == 0x0d)
		{
			a = atoi(ss);
			ss[2] = { ' ' };
			u_ss = 0;
			user[u_count] = a;
			u_count++;
			coord.X += 20;
			SetConsoleCursorPosition(hout, coord);
			if (coord.X > 80)
			{
				coord.Y += 1;
				coord.X = 6;
				SetConsoleCursorPosition(hout, coord);
			}
		}
		else if (ch >= '0' || ch <= '9')
		{
			ss[u_ss] = ch;
			u_ss++;
		}
	}
	printf("\n正确答案:\n");
	for (int i = 0; i < 50; i++)
	{
		printf("%4d", realize[i + 1]);
	}
	printf("\n你的答案:\n");
	for (int i = 0; i < 50; i++)
	{
		printf("%4d", user[i + 1]);
	}
	_getche();
	printf("\nPlease input any key to continue...");
	system("cls");
}