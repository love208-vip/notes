--------------------------------
aio								|
--------------------------------
	* ѧϰ����
		http://www.jianshu.com/p/b5e347b3a17c

	* �¼�������IO
	* 3.5�汾��ǰ
			1,���������ϱ�ʶע��  @asyncio.coroutine
				Ȼ����coroutine�ڲ���yield from������һ�� coroutine ʵ���첽����
			2,���� event_loop ����(asyncio.get_event_loop())
			3,ִ�� event_loop ����� run_until_complete()����,��������ʵ����Ϊ�������ݽ�ȥ
				* �ú�������Ҳ������  asyncio.wait(tast_arr) ��������ֵ
				* ��ʾһ����ִ�ж��������
				* demo : 
					tasks = [hello(), hello()]
					loop.run_until_complete(asyncio.wait(tasks))
			4,�ر� event_loop ���� (close())

	* 3.5 �汾�Ժ�
		* ��asyncio�ṩ�� @asyncio.coroutine ���԰�һ��generator���Ϊcoroutine����,Ȼ����coroutine�ڲ���yield from������һ�� coroutine ʵ���첽����
		* Ϊ�˼򻯲����õر�ʶ�첽IO����Python 3.5��ʼ�������µ��﷨async��await,������coroutine�Ĵ��������׶�
		* ��ע��,async��await�����coroutine�����﷨,Ҫʹ���µ��﷨,ֻ��Ҫ�������򵥵��滻
		* ����
			1,��������ʹ�� @asyncio.coroutine ע���ʶ,��ʹ�� async �ؼ��ֱ�ʶ
			2,��ʹ�� yield from ���,��ʹ�� await �ؼ���
		* demo
			import asyncio

			async def demo(name):
				print('[%s]1'%(name))
				r = await asyncio.sleep(2)
				print('[%s]2'%(name))
				
			loop = asyncio.get_event_loop()
			loop.run_until_complete(asyncio.wait([demo('Kevin'),demo('Litch')]))
		
	* event_loop api
		create_task()
		run_until_complete()
		run_forever()
		create_server()
		close()
		stop()
			

--------------------------------
aio-����						|
--------------------------------
	import asyncio

	@asyncio.coroutine
	def hello():
		print("Hello world!")
		# �첽����asyncio.sleep(1):
		r = yield from asyncio.sleep(1)
		print("Hello again!")

	# ��ȡEventLoop:
	loop = asyncio.get_event_loop()
	# ִ��coroutine
	loop.run_until_complete(hello())
	loop.close()
	'''
		Hello world!
		Hello again!
	'''

--------------------------------
aio-����						|
--------------------------------
	import threading
	import asyncio

	@asyncio.coroutine
	def hello():
		print('Hello world! (%s)' % threading.currentThread())
		yield from asyncio.sleep(1)
		print('Hello again! (%s)' % threading.currentThread())

	loop = asyncio.get_event_loop()
	tasks = [hello(), hello()]
	loop.run_until_complete(asyncio.wait(tasks))
	loop.close()
	'''
		Hello world! (<_MainThread(MainThread, started 6956)>)
		Hello world! (<_MainThread(MainThread, started 6956)>)
		Hello again! (<_MainThread(MainThread, started 6956)>)
		Hello again! (<_MainThread(MainThread, started 6956)>)
	'''

--------------------------------
aio-����ص�					|
--------------------------------
import asyncio

async def demo(var):
    asyncio.sleep(1)
    return var * var

# ���� loop
loop = asyncio.get_event_loop()

# ���� task
task = asyncio.ensure_future(demo(5))

# task��Ӽ���,�ڻص������е����βε� result() ��ȡ�����Ϣ
# task�ͻص����x����,ʵ������ͬһ������
task.add_done_callback(lambda x : print('result:%s'%(x.result())))

# ִ������
loop.run_until_complete(asyncio.wait([task]))

loop.close()

--------------------------------
aio-server						|
--------------------------------
import asyncio

class SimpleProtocol(asyncio.Protocol):

    # �µ�����
    def connection_made(self, transport):
        self.transport = transport

    # �յ��µ�����
    def data_received(self, data):
        # ���յ���������Ӧ���ͻ���
        self.transport.write(data)

    # ���ӶϿ�
    def connection_lost(self, exception):
        #server.close()
        pass

# ���� event_loop
loop = asyncio.get_event_loop()

# ����������ʵ��
server = loop.run_until_complete(loop.create_server(SimpleProtocol, 'localhost', 1024))

# ����
loop.run_until_complete(server.wait_closed())

--------------------------------
aio-ʵս						|
--------------------------------

# �ɰ�ʵ��
import asyncio

@asyncio.coroutine
def wget(host):
    print('wget %s...' % host)
    connect = asyncio.open_connection(host, 80)
    reader, writer = yield from connect
    header = 'GET / HTTP/1.0\r\nHost: %s\r\n\r\n' % host
    writer.write(header.encode('utf-8'))
    yield from writer.drain()
    while True:
        line = yield from reader.readline()
        if line == b'\r\n':
            break
        print('%s header > %s' % (host, line.decode('utf-8').rstrip()))
    # Ignore the body, close the socket
    writer.close()

loop = asyncio.get_event_loop()
tasks = [wget(host) for host in ['www.sina.com.cn', 'www.sohu.com', 'www.163.com']]
loop.run_until_complete(asyncio.wait(tasks))
loop.close()


# �°�ʵ��
import asyncio

async def demo(target):
    reader, writer = await asyncio.open_connection(*target)
    header = 'GET / HTTP/1.0\r\nHost: %s\r\n\r\n'%(target[1])
    writer.write(bytes(header,'UTF_8'))
    await writer.drain()
    while True:
        line = await reader.readline()
        if line == b'\r\n':
            break
        print('%s header > %s' %(target[1], line.decode('utf-8').rstrip()))
    writer.close()

loop = asyncio.get_event_loop()
loop.run_until_complete(asyncio.wait([demo(('www.qq.com',80)),demo(('www.javaweb.io',80))]))
loop.close()

--------------------------------
aio-asyncio						|
--------------------------------
	wait()
	gather()
		* �� wait() һ��,�������᷵��һ��[],�����ÿ��Ԫ����ÿ��Э��ִ����Ϻ�Ľ��
	ensure_future()
	get_event_loop()
	as_completed()
	open_connection(ip, port)
		* ��һ���첽IO����
		* ���� (reader,writer) Ԫ��
	


	

	
