
��������������������������������������������������������
һ,Hiernate��������			|
��������������������������������������������������������
Hibernateӳ������
����ӳ������
Hibernate		java					sql			ȡֵ
-------------------------------------------------------------
������������,һ��ʹ��Hibernatָ��������						 |
-------------------------------------------------------------
int/Integer		int/java.lang.Iteger	INTEGER		4
long			long/java.lang.LONG		BIGINT		8
short			short/Short				SMALLINT	2
byte			byte/Byte				TINYINT		1
float			float/Float				FLOAT		4
double			double/Double			DOUBLE		8
big_decimal		java.math.BigDecimal	NUMERIC		8λ����2λС������
character		car/character String	CHAR(1)		�����ַ�
boolean			boolean/Boolean			BIT			����
yes_no			boolean/Boolean			CHAR(1)		����
true_false		boolean/Boolean			CHAR(1)		����
-------------------------------------------------------------
javaʱ�����������(��Ҫ��ס)								 |
-------------------------------------------------------------
date			util.Date.sql.Date		DATE		YYYY-MM-DD		   ---> ������,û��ʱ���������������ֶ�
time			util.Date.sql.Time		TIME		HH:mm:ss
timestamp		util.Date/sql.timestamp	DATETIME	YYYYMMDDHHmmss	[�Ѳ�,Ĭ��]---> ������ʱ����,ʱ���,�����û���ע��ʱ��,��Ʒ�Ķ���ʱ��
calendar		java.util.Calendar		TIMESTAMP	YYYYMMDDHHmmss
calendar_date	java.util.Calendar		DATE		YYYY-MM-DD
-------------------------------------------------------------
�����ݶ�������												 |
-------------------------------------------------------------
binary			byte[]					MEDIUMBLOB(BLOB)	[�Ѳ�,Ĭ��]
text			String					LONGTEXT			[�Ѳ�,Ĭ��]
serializable	ʵ����					BARBINARY(BLOB)
clob			sql.Clob				CLOB
blob			sql.Blob				BLOB

