# Springboot_Vue_Epidemic_prevention
基于Idea开发Springboot+Vue疫情防控管理系统毕业源码案例设计

开发工具用idea不要用eclipse,数据库是mysql8.0版本
管理员账号密码: admin/111111

系统要求：
##1.疫情人员管理模块
确诊感染者信息管理：姓名、年龄、性别、身份证号等。治疗信息如下：感染源、是否重症、住院时间、发病症状、诊治医院、信息备注以及相应的核酸检测及ct检测历史。
入境人员信息管理：姓名、年龄、性别、身份证号，是否发热咳嗽，来源地，离开来源地时间，乘坐过的交通工具，车次，座位号，隔离起始日期，隔离结束日期，隔离地址，家庭住址，每日体温检测，核酸检测记录(共四次），解除隔离或转为确诊感染者
（说明：对入境人员（符合规定的从澳门进入内地人员除外）一律实行“14 天+7 天+7 天+4 次核酸检测”健康管理服务措施，即：对入境人员实行集中隔离医学观察 14 天（期间进行 2 次核酸检测；14 天期满后，对符合解除集中隔离条件的人员纳入社区管理）+继续实施居家隔离观察 7 天（居家隔离第 7 天进行第3 次核酸检测）+对居家隔离观察期满、核酸检测阴性者继续实施日常自我健康监测 7 天（结束前进行第 4 次核酸检测）
中高风险接触者信息管理：姓名、年龄、性别、身份证号以及接触情况（如到过中高风险地区、与患者或者高风险接触者共同乘坐过交通工具、是否冷链食品的相关工作人员）所在隔离地址、起始隔离日期等。隔离14天期间，每日体温检测，进行三次核酸检测并记录检测结果。满14天后，根据人员的身体状况及检测结果可将其转确诊感染者或者解除隔离。
低风险接触者信息管理：姓名、年龄、性别、身份证号，家庭住址，乘坐过的交通工具、是否有健康码
##2.疫情工作管理模块
疫情动态管理（标题,内容,发布人,发布日期）
领导信息管理（编号,领导姓名,性别,组织名称,职务,联系电话,备注,照片）
##3.疫情防控统计模块
入境人员（所在地区人数统计,性别人数统计,年龄段统计）
中高风险接触人员统计（所在地区人数统计,性别人数统计,年龄段统计）
确诊感染人员统计（所在地区人数统计,性别人数统计,年龄段统计）
##4.用户管理
用户账户的增删改查，以及修改个人信息。
防控统计用可视化显示
启动系统的时候先是注册账号然后登录进入系统界面，界面的左侧就是上面的各管理模块，右侧是疫情动态公告以及模块3的可视化显示图。
