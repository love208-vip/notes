------------------------
python-�쳣����			|
------------------------
	* ��JAVA���
	* �쳣�Ĵ��������ȼ�,�ڼ̳���ײ����Ӧ��������.
	* �����﷨
		# ÿ���쳣���� catch
			try:
				pass
			except LookupError as error:
				pass
			except KeyError as error:
				pass
			finally:
				pass
		
		# ����쳣ͳһ catch
			try:
				pass
			except (LookupError,KeyError) as error:
				pass
			finally:
				pass
		
		# �� else ��catch
			try:
				pass
			except (LookupError,KeyError) as error:
				pass
			else:
				print('һ������,����������,û�з����쳣��ʱ��ִ��')
			finally:
				pass
	
	* �׳��쳣
		raise BaseException("Ŷ��,�쳣��")


		
------------------------
python-�쳣����ϵ		|
------------------------
	Exception

------------------------
python-�Զ����쳣		|
------------------------
	* �Զ�����,�̳� :Exception ��
	* ʹ�� raise �׳��쳣(��ʵҲ�Ǵ����쳣ʵ��)
	* demo
		class ServiceException(Exception):
			def __init__(self,info):
				self.info = info
			
		#	def __str__(self):
		#		return self.info
		try:
			raise ServiceException('�Զ����쳣��Ϣ')
		except ServiceException as serviceException:
			print(serviceException) # �Զ����쳣��Ϣ

	