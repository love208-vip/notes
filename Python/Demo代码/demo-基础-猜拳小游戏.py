# -*- coding: UTF-8 -*-
'''
Created on 2017��6��15��

@author: Kevin
'''

import random

def guess():
    num = random.randrange(100)
    print("�Ѿ��������һ����,����Կ�ʼ����")
    while True:
        result = int(input())
        if result > num :
            print("[%s] ����"%(result))
        elif result < num:
            print("[%s] С��"%(result))
        else:
            print("������������[%s]"%(result))
            break;

while True:
    order = input("����[o]��ʼ��Ϸ,����[q]�˳� \n")
    if order == 'o':
        guess()
    elif order == 'q':
        print("�ټ�,��ӭ�´μ�����")
        break
    else:
        print("ָ�����")
        