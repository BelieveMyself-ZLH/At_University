#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
/*
srand()函数定义 ： void srand (unsigned int seed);
通常可以利用geypid()或time(0)的返回值来当做seed
如果你用time(0)的话，要加入头文件#include<time.h>

例如：
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define random(x) (rand()%x)

void main()
{

srand((int)time(0));
for(int x=0;x<10;x++)
printf("%d/n",random(100));
}
*/

#define range0 100;		//数字计算的范围
#define range1 3;		//运算符有+，-，*，/
#define random(x) rand()%x;//产生随机数

//欢迎菜单
void WelcomeMenu();
//主菜单
int Menu();
//结束菜单
void OverMenu();
//功能实现
void FunctionRealize(int num);
//选择四则运算
void ChoseArithmetic();
void RandomArithmetic();				//随机四则运算switch

//运算模板
void ModelOperation(int a, int b, char c);

void Addition(int a, int b);		//  +
void Subtraction(int a, int b);		//  - 
void Multiplication(int a, int b);	//  *
void Division(int a, int b);		//  /
void ADD();