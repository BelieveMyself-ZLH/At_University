#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
/*
srand()�������� �� void srand (unsigned int seed);
ͨ����������geypid()��time(0)�ķ���ֵ������seed
�������time(0)�Ļ���Ҫ����ͷ�ļ�#include<time.h>

���磺
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

#define range0 100;		//���ּ���ķ�Χ
#define range1 3;		//�������+��-��*��/
#define random(x) rand()%x;//���������

//��ӭ�˵�
void WelcomeMenu();
//���˵�
int Menu();
//�����˵�
void OverMenu();
//����ʵ��
void FunctionRealize(int num);
//ѡ����������
void ChoseArithmetic();
void RandomArithmetic();				//�����������switch

//����ģ��
void ModelOperation(int a, int b, char c);

void Addition(int a, int b);		//  +
void Subtraction(int a, int b);		//  - 
void Multiplication(int a, int b);	//  *
void Division(int a, int b);		//  /
void ADD();