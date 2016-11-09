package promise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author WanChuanLai
 * @create 8/22/16.
 */
public class TestMain {
    private TaskPromise promise;
    private TaskFuture future;

    @Before
    public void setUp() {
        promise = new DefaultTaskPromise();
        future = promise.getFuture();
    }

    @Test
    public void testSetSuccessWithNull() throws InterruptedException, ExecutionException {
        promise.setSuccess(null);
        Assert.assertTrue(future.isDone());
        Assert.assertTrue(future.isSuccess());
        Assert.assertTrue(null == future.get());
        Assert.assertTrue(null == future.getNow());
    }

    @Test
    public void testSuccessWithObj() throws InterruptedException, ExecutionException {
        Object result = new Object();
        promise.setSuccess(result);
        Assert.assertTrue(future.isDone());
        Assert.assertTrue(future.isSuccess());
        Assert.assertTrue(result == future.get());
        Assert.assertTrue(result == future.getNow());
    }

    @Test
    public void testSetFailure() throws InterruptedException {
        Throwable cause = new IllegalStateException("test");
        promise.setFailure(cause);
        Assert.assertTrue(future.isDone());
        Assert.assertFalse(future.isSuccess());
        Assert.assertTrue(null == future.getNow());
        try {
            future.get();
            Assert.fail();
        } catch (ExecutionException e) {
        }
    }

    @Test
    public void testTrySuccessFail() {
        promise.setSuccess(null);
        Assert.assertFalse(promise.trySuccess(null));
    }

    @Test
    public void testAddAndRunCallback() {
        final String right = "right";
        final String[] result = new String[1];
        future.onComplete(new TaskCallback() {
            @Override
            public TaskFuture apply(TaskFuture f) {
                result[0] = right;
                return f;
            }
        });
        promise.setSuccess(null);
        Assert.assertEquals(right, result[0]);
    }

    @Test
    public void testAddCallbackAfterComplete() {
        final String right = "right";
        final String[] result = new String[1];
        promise.setSuccess(null);

        future.onComplete(new TaskCallback() {
            @Override
            public TaskFuture apply(TaskFuture f) {
                result[0] = right;
                return f;
            }
        });

        Assert.assertTrue(future.isDone());
        Assert.assertEquals(right, result[0]);
    }

    @Test
    public void testOnSuccess() {
        final String right = "right";
        final String[] result = new String[1];

        future.onSuccess(new TaskCallback() {
            @Override
            public TaskFuture apply(TaskFuture f) {
                result[0] = right;
                return f;
            }
        });

        promise.setSuccess(null);
        Assert.assertEquals(right, result[0]);
    }

    @Test
    public void testOnSuccessNotRun() {
        final String right = "right";
        final String[] result = new String[1];

        future.onSuccess(new TaskCallback() {
            @Override
            public TaskFuture apply(TaskFuture f) {
                result[0] = right;
                return f;
            }
        });

        promise.setFailure(new IllegalStateException());
        Assert.assertNull(result[0]);
    }

    @Test
    public void testOnFailure() {
        final String right = "right";
        final String[] result = new String[1];

        future.onFailure(new TaskCallback() {
            @Override
            public TaskFuture apply(TaskFuture f) {
                result[0] = right;
                return f;
            }
        });

        promise.setFailure(new IllegalStateException("test"));
        Assert.assertEquals(right, result[0]);
    }

    @Test
    public void testOnFailureNotRun() {
        final String right = "right";
        final String[] result = new String[1];

        future.onFailure(new TaskCallback() {
            @Override
            public TaskFuture apply(TaskFuture f) {
                result[0] = right;
                return f;
            }
        });

        promise.setSuccess(null);
        Assert.assertNull(result[0]);
    }

    @Test
    public void testAwait() throws InterruptedException {
        final String[] result = new String[1];
        Thread t = new Thread(new Runnable() {


            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                promise.setSuccess(null);
            }
        });
        t.start();
        future.await();
        Assert.assertTrue(future.isSuccess());
        Assert.assertTrue(null == result[0]);
    }

    @Test
    public void testAwaitTimeout() throws InterruptedException {
        Thread t = new Thread(new Runnable() {


            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                }
                promise.setSuccess(null);
            }
        });
        t.start();
        Assert.assertFalse(future.await(1, TimeUnit.SECONDS));
        Assert.assertFalse(future.isDone());
        t.interrupt();
    }
}
