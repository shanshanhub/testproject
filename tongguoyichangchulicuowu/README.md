###通过异常处理错误
java的基本概念是:结果不佳的代码不能运行
####概念
####基本异常
异常情形(exceptional condition):是指阻止当前方法或作用域继续执行的问题.
普通异常:在当前坏境下能够的到足够的信息,总能处理这个异常.
而异常情形:就不能继续下去了,因为在当前坏境下无法获得必要的信息来解决问题,你所能做的就是从当前坏境跳出,
         并且把问题交给上一次处理.这就是抛出异常时所发生的事情.
