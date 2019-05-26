1.情绪判断听课情况

​     对每一张PPT每个人情绪分析

2.视线热点



* 教师
  * t_id
  * password

* 学生
  * s_id
  * password

* 开课
  * c_id 课程id
  * t_id 教师id
  * time 发布时间
  * title PPT主题
  * filename 文件名

* 学生-开课
  * c_id
  * t_id
  * time 加入时间

* 分析

  * c_id 课程id
  * s_id 学生id
  * cur_page 当前页码
  * data 数据

- [x] 教师登录 

- [x] 学生登录

- [ ] 上传PPT

- [x] PPT转换
- [ ] 教师开课获取课堂暗号
- [ ] 学生加入，收到PPT画面
- [ ] 教师翻页，学生画面改变
- [ ] 学生看，记录数据
- [ ] 教师点下课
- [ ] 教师查看历史记录(可选)

页面：

​	登录

教师

​	开课

​	上课

学生

​	输暗号

​	操作页面






'curPage':4,
data:{

​	score:"",​	

    anger：愤怒——14.67%
    disgust：厌恶——0.163%
    fear：恐惧——0.163%
    happiness：高兴——1.936%
    neutral：平静——68.429%
    sadness：伤心——14.67%
    surprise：惊讶——11.633%	
}



1. 新开一节课
   1. 之前没有课件
   2. 之前已经有课件
2. 上了一半的课