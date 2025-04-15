package com.xiaohuajun.wonderful.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author huawei
 */
public class CompletableFuture_test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DeptService deptService = new DeptService();
        UserService userService = new UserService();
        User user = new User(1, "huajun", 31);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.supplyAsync(() -> {
            Dept dept = deptService.getById(1);
            return dept;
        }).thenAccept(dept -> {
            //注意这里用到了上个线程的返回值dept
            user.setDeptId(dept.getId());
            user.setDeptName(dept.getName());
            userService.save(user);
        });
        System.out.println("线程：" + Thread.currentThread().getName() +
                " 结果：" + userCompletableFuture.get());
    }





}
