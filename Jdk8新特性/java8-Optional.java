----------------------
Optional-����		  |
----------------------
	1,����һ���յ� Optional
		Optional<Car> optCar = Optional.empty();
	
	2,����һ��ֵ�����ǿյ� Optional
		Optional<Car> optCar = Optional.of(car);
		* ��� car ֵΪ null,��ô���׳� ��ָ���쳣
	
	3,���Խ��� null �� Optional
		Optional<Car> optCar = Optional.ofNullable(car);

----------------------
Optional-����		  |
----------------------
	isPresent();
		* �����ֵ���� true,Դ�� return value != null;

	ifPresent(Consumer<? super T> consumer);
		* ���ֵ��Ϊ null,��ô�� value ���ݸ� consumer ִ��

	get();
		* ��ȡֵ,���ֵ���������׳� NoSuchElement �쳣

	orElse(T data);
		* ����ֵ���ڵ�ʱ�򷵻�ֵ,�������һ��Ĭ��ֵ(�β�)
	
	orElseGet(Supplier<? extends T> other);
		* ����ֵ���ڵ�ʱ�򷵻�ֵ,���ֵ����������� other Lambda�ĵ� get��������Ĭ��ֵ
	
	orElseThrow();
		* ����ֵ���ڵ�ʱ�򷵻�ֵ,������������׳��쳣
	
	map(Function function);
		* �����ֵ,�͵��� function ���д���
		* û��ֵ,�ͷ��� Optional.empty();
	
	flatMap(Function function);
		* ��map���,Ҫ�󷵻�ֵ������ Optional
	

	


	

	