----------------------------
RocketMQ-����				|
----------------------------
	# ��,û��.���ǰ���ְֵ�����
		'��������'
		'˳������'
		'��Ϣ����'
		'��ʱ��Ϣ'

	# �������汾,һ���ǿ�Դ��.һ���Ƿǿ�Դ��

	# ��һ��ֲ�ʽ,����ģ���м��.���������ص�
		�ܹ��ϸ�֤��Ϣ˳��
		���ṩ�ḻ����Ϣ��ȡģʽ
		��Ч�Ķ�����ˮƽ��չ����
		ʵʱ����Ϣ���Ļ���
		�ڼ���Ϣ�ѻ�����

	# �����ĵ�
		http://www.boyunjian.com/javadoc/com.alibaba.rocketmq/rocketmq-client/3.1.3/_/com/alibaba/rocketmq/client/consumer/listener/MessageListenerOrderly.html

	# ţ��֮��
		ǿ����Ⱥ,�ǵ����Ʒ.����ڵ�߿���.ˮƽ����չ
		������Ϣ�ѻ�����,��Ϣ�ѻ���,д���ӳٵ�
		֧���������
		��Ϣʧ�����Ի���
		��Ϣ�ɲ�ѯ
		��Դ������Ծ
		�����(��������˫ʮһ����)
	
	# ȱ��
		RocketMQ,��������ظ����ѵ�����

	# Metaq3.0�汾����,��Ʒ���Ƹ�ΪRocketMQ
	
	# RocketMQ '����ѭ�κι淶',����Ǻܵ��,�����ǲο��˸��ֹ淶��ͬ���Ʒ�����˼��

	# �汾���
		1.x��2.x,��Ⱥ������ҪZookeeper
		3.x��������zk,�Լ��ڲ�ʵ����һ��name server�����
	
	# ���ص�ַ
		https://github.com/alibaba/RocketMQ/releases
	
	# �˿�����
		nameserver	9876
		mqserver	10911
	
	# ��װ(Linux)
		1,��git��clone���µĵķ�����
			* git clone git@github.com:alibaba/RocketMQ.git
		2,����Ŀ¼,ִ�� install.sh
			* ����Ҫ��maven����,���ܽ��б���
		3,����OK��,����Ŀ¼,��ȡ��rocketmq
			* target/alibaba-rocketmq-broker/alibaba-rocketmq
		# ������������,��windows��װҲû�������
	
	# ������������
		export ROCKETMQ_HOME=/usr/local/rocketmq/alibaba-rocketmq
		export PATH=$PATH::$ROCKETMQ_HOME/bin

	# �������
		