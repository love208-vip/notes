package com.kevin.main;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * cglib��̬������ʾ,ֻ�ܶ������ɴ���
 * */
public class CGLIB <T>implements MethodInterceptor
{
	private T t;
	/**
	 * Ψһ����
	 * */
	public CGLIB(T t)
	{
		this.t = t;
	}
	/**
	 * ʹ��cglib���ɴ���
	 * */
	public T createProxy()
	{
		//��������
		Enhancer enhancer = new Enhancer();
		//�̳и���
		enhancer.setSuperclass(t.getClass());
		//���ûص�,��ʵ���Ǵ���һ��ʵ����ָ���ӿڵĶ���..�����ɱ���̳�,ֱ�Ӵ���this
		enhancer.setCallback(this);
		//��������
		return (T) enhancer.create();
	}
	/**
	 * ����ʽ
	 * */
	public Object intercept(Object proxy, Method method, Object[] args,MethodProxy methodProxy) throws Throwable
	{
		System.out.println("ǰ����ǿ");
		Object result =  methodProxy.invokeSuper(proxy, args);
		System.out.println("������ǿ");
		return result;
	}
}

