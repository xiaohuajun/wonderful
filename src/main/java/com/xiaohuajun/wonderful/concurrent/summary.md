## java并发编程
### CAS（compare and swap）
- 定义：
    - 利用cpu的cmpxchg指令实现；包括三个运算：内存地址：V，期望值：（旧值）A，被线程修改后的新值：B
    - 工作流程：
        - 每次从内存获取旧值
        - 线程对旧值进行修改
        - 每次带着修改后的新值、期望值与目前V内存地址中的值比较，相等则把新值赋给变量
        否则继续比较，直到成功为止
- 问题：
    - ABA问题：如果变量为A，被成功修改为B，又变成了A；cas检测值是没有发生变化，实际上已经法成变化
        > 解决：版本号，在变量上加上版本号，A1,B2,A3; 
        AtomicStampedReference,AtomicMarkableReference除了比较变量值是否发生变化，还需要
        比较版本号是否发生变化
        
    - 循环开销大：
        > 解决：后续补充
    
    - 只能支持对一个变量进行cas：
        > 解决：1、多个变量分别加上锁；2、把多个变量合成一个变量：i = 2，j = 3；ij = 23,对ij
          进行cas；AtomicReference 这个类保证引用对象之间的原子性，
          就可以把多个变量放在一个对象里面进行cas
          
            
        
   
        
     