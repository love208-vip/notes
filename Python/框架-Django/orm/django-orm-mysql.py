
pip install mysqlclient
# ��Ҫ��װ mysqlclient ģ��


DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',	# ָ��DB����ΪMYSQL
        'NAME': 'demo',							# ���ݿ�����
        'HOST':'59.110.167.11',					# IP
        'PORT':'1124',							# �˿�
        'USER':'root',							# �û���
        'PASSWORD':'KevinBlandy_mysql'			# ����
    }
}

