package com.rendawei.prototype;


/*
*   原型模式，用原型实例指定创建对象的忠烈，斌且通过拷贝这些类型，创建新的对象
*
*   原型模式使一种创建型设计模式，允许一个对象再创建另外一个可定制对象，无需知道如何创建的细节
*
*   工作原理： 通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝他们来实施创建，即对象.clone()
*
*
*   方法：用原型类实现cloneable接口，并重写方法，这样再clone的时候，就可以对象.clone()直接克隆对象了
*
*   注意事项：
*     1. 创建新的对象比较复杂时：可以利用原型模式简化对象的创建过程，同时也能够提高效率，
*     2. 不用重新初始化对象，而是动态地获得对象运行时的状态
*     3. 如果原始对象发生变化（增加或者减少属性），其他克隆对象的也会发生相应的变化，无需修改代码
*     4. 缺点：需要未每一个类配置一个克隆方法，这对全新的类来说不是很难，但对已有的类进行改造时，需要修改其源代码，违背了ocp原则
*     5. 在实现深克隆的时候可能需要比较复杂的方法
*
*
* */