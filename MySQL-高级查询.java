-------------------
MySQL �߼���ѯ		|
--------------------


-------------------
Exam-��һ��			|
--------------------
	# ��ѯ��������5��Ա���Ĳ���,��ʾ���ű��,��������,����λ��,��������
	# ��:d.deptno,d.dname,d.loc,��������
	# ��:dept d,emp e
	# ����:e.deptno = d.deptno	
	
		SELECT
			d.deptno,
			d.dname,
			d.loc,
			e.count
		FROM
			dept d,
			(SELECT deptno,COUNT(*) `count`  FROM emp GROUP BY deptno HAVING COUNT(*) >= 5) e
		WHERE
			d.deptno = e.deptno
		

	# ��ѯ�����в��ŵ���Ϣ,�Լ��䲿�ŵ�Ա����
		SELECT
			d.deptno,
			d.dname,
			d.loc,
			ifnull(e.count,0) AS `count`
		FROM
			dept d
		LEFT JOIN
			(SELECT deptno,COUNT(*) `count`  FROM emp GROUP BY deptno) e
		ON
			d.deptno = e.deptno;
	
-------------------
Exam-�ڶ���			|
--------------------
	# ��ȡ����Ա,����ֱ���ϼ�������
		SELECT
			t.ename AS `Ա��`,
			ifnull(t1.ename,'BOSS') AS `�ϼ�`
		FROM
			emp t
		LEFT JOIN
			emp t1 ON t.mgr = t1.empno;

	# ��ȡ,����Ա��������ֱ���ϼ���Ա�������쵼
		SELECT
			e.ename as `Ա��`,
			m.ename as `�ϼ�`
		FROM
			emp e,
			emp m
		WHERE
			e.mgr = m.empno;
		
	

-------------------
Exam-������			|
--------------------
-------------------
Exam-������			|
--------------------
	# �г��ܹ���������ֱ���ϼ�������Ա���ı��,����,��������
		SELECT
			t.ename,
			t2.dname
		FROM 
			emp t,
			emp t1,
			dept t2
		WHERE 
			t.mgr = t1.empno
		AND
			t.hiredate < t1.hiredate
		AND
			t.deptno = t2.deptno;

-------------------
Exam-������			|
--------------------
	# �г���������,����Щ���ŵ�Ա����Ϣ,ͬʱ�г���Щû��Ա���Ĳ���
		SELECT
			t.dname AS `����`,
			ifnull(e.ename,'û�в���') AS `Ա��`
		FROM
			dept t
		LEFT JOIN
			emp e ON t.deptno = e.deptno;

-------------------
Exam-������			|
--------------------
	
-------------------
Exam-������			|
--------------------
	# �г����н�ʴ���15000�ĸ��ֹ���,�Լ����´˹���������
		SELECT 
			job AS `����`,
			count(*) AS `����`
		FROM
			emp
		GROUP BY job HAVING min(sal) >= 15000;

-------------------
Exam-�ڰ���			|
--------------------
	# �г������۲�������Ա������,�ٶ���֪�����۲��Ĳ��ű��
		SELECT 
			e.ename
		FROM
			emp e,
			dept d
		WHERE
			d.dname = '���۲�'
		AND
			e.deptno = d.deptno;
	
-------------------
Exam-�ھ���			|
--------------------
-------------------
	# �г�н����ڹ�˾ƽ��н���Ա����Ϣ,���ڲ�������,�ϼ��쵼,н�ʵȼ�
	SELECT
	  e.ename AS `Ա��`,
	  d.dname AS `����`,
	  m.ename AS `�ϼ�`,
	  s.grade AS `н�ʵȼ�`
	FROM
		emp e 
	LEFT JOIN 
		dept d ON d.deptno = e.deptno
	LEFT JOIN 
		emp m ON e.mgr = m.empno
	LEFT JOIN 
		salgrade s ON e.sal BETWEEN  s.losal AND s.hisal
	WHERE
		e.sal > (SELECT avg(sal) FROM emp);

--------------------
Exam-��ʮ��			|
--------------------
	# �г�����ͳ������ͬ����������Ա������������
	SELECT
		e.ename AS `Ա��`,
		d.dname AS `����`
	FROM 
		emp e,
		dept d
	WHERE
		e.job = (SELECT job FROM emp WHERE ename = '��ͳ')
	AND
		e.deptno = d.deptno;

-------------------
Exam-��ʮһ��		|
--------------------
	# �г�н�����,��30���Ź���������Ա����н��.
		SELECT
			e.ename,
			e.sal,
			d.dname
		FROM
			emp e,
			dept d
		WHERE
			e.deptno = d.deptno
		AND
			e.sal > ALL (SELECT sal FROM emp WHERE deptno = 30);
-------------------
Exam-��ʮ����		|
--------------------
	
-------------------
Exam-��ʮ����		|
--------------------
-------------------
Exam-��ʮ����		|
--------------------
-------------------
Exam-��ʮ����		|
--------------------
-------------------
Exam-��ʮ����		|
--------------------