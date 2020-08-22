<dubbo:provider/>
	* provider 作为服务提供者的默认配置

	<dubbo:provider
		accepts=""			
			* 限制服务提供端的连接最大数
		accesslog=""		
			* 是否开启访问日志,或者指定日志文件地址
		actives=""
		application=""
		async="false"
		buffer=""
		cache=""
		callbacks=""
		charset=""
		client=""
		cluster=""
		codec=""
		connections=""		
			* 制客户端服务使用连接连接数：(如果是长连接，比如Dubbo协议，connections表示该服务对每个提供者建立的长连接数)
		contextpath=""
		default=""
		delay="0"
		deprecated=""
		dispather=""
		document=""
		dynamic=""
		exchanger=""
		executes=""
		export=""
		filter=""
		group=""
		host=""
		id=""
		iothreads=""
		layer=""
		listener=""
		loadbalance=""
		local=""
		merger=""
		mock=""
		module=""
		monitor=""
		networker=""
		onconnect=""
		ondisconnect=""
		owner=""
		path=""
		payload=""
		port=""
		prompt=""
		protocol=""
		proxy=""
		queues=""
		register=""		//是否是只订阅
		registry=""		//注册中心
		retries=""		//容错策略,重试次数
		scope=""
		sent=""
		serialization=""
		server=""
		status=""
		stub=""
		telnet=""
		threadpool=""
		threads=""
		timeout="0"
		token=""
		transporter=""
		validation=""
		version="0.0.0"
		wait=""
		weight=""
	/>