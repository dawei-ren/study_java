package com.rendawei.myList;


/*
*
*   1. ArrayList 实现了基于动态数组的数据结构，LinkedList基于链表的数据结构
*   2. 对于随机访问get和set，ArrayList优于LinkedList，因为ArrayList可以随机定位，而LinkedList要移动指针一步一步移动到节点处
*   3. 对于新增和删除操作add和remove，LinkedList比较占优势，只需要对指针进行修改即可，而ArrayList要移动数据来填补被删除的对象的空间
*
*   总结：
*     ArrayList适合频繁的get、set操作
*     LinkedList适合频繁的insert、delete操作
*
*
* */