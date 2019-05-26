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

- [x] 上传PPT

- [x] PPT转换
- [x] 教师开课获取课堂暗号
- [x] 学生加入，收到PPT画面
- [x] 教师翻页，学生画面改变
- [x] 学生看，记录数据
- [x] 教师点下课
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





## 接口

IP = 106.14.212.49

port = 8092

projectName = 

### 1.登录

- [x] 

- URL:${IP}:\${port}/\${projectName}/user/login
- method:POST
- param:
  - username:用户名，学号
  - password:密码，不要超过20位
  - type 类型
- return:如果成功，可以进入下一步操作，如果失败，从message中取出服务器返回的报错信息展示即可。

### 2.上传课件并开课

- [x] 

- URL:${IP}:\${port}/\${projectName}/class/uploadAndStart
- method:POST
- param:
  - title 主题
  - file PPT二进制文件
- return:如果成功，object字段返回一个JSON对象，如果失败，从message中取出服务器返回的报错信息展示即可。

```json
{
    "pageNum": 45, # PPT总页数
    "cid": 7	# 课程id
}
```

### 3.获取教师历史保存的课件

- [x] 

- URL:${IP}:\${port}/\${projectName}/class/getHisClass
- method:GET
- param:
- return:如果成功，object字段返回一个JSON对象，如果失败，从message中取出服务器返回的报错信息展示即可。

```json
[{
    "cid": 3,
    "title": "测试"
},
...
{
    "cid": 7,
    "title": "测试"
}]
```

### 4.根据历史课程id开启一门新课

- [x] 

- URL:${IP}:\${port}/\${projectName}/class/startByHisCid
- method:POST
- param:
  - cid 课程id
  - title 课程主题
- return:如果成功，object字段返回一个JSON对象，如果失败，从message中取出服务器返回的报错信息展示即可。

```json
{
    "pageNum": 45,
    "cid": 18
}
```

### 5.根据课程id获取当前的页码

- [x] 

- URL:${IP}:\${port}/\${projectName}/class/getCurPage
- method:GET
- param:
  - cid 课程id
- return:如果成功，object字段返回页码，如果失败，从message中取出服务器返回的报错信息展示即可。

### 6.更新课程id对应的当前的页码

- [x] 

- URL:${IP}:\${port}/\${projectName}/class/updateCurPage
- method:POST
- param:
  - cid 课程id
  - newPageNum 新的页码
- return:如果成功，object字段返回页码，如果失败，从message中取出服务器返回的报错信息展示即可。

### 7.学生加入课程

- [x] 

* URL:${IP}:\${port}/\${projectName}/class/studentGetIntoClazz
* method:POST
* param:
  - cid 课程id
* return:如果失败，从message中取出服务器返回的报错信息展示即可。

### 8.学生发送收集数据到后台

- [ ] 

- URL:${IP}:\${port}/\${projectName}/class/colStuDat
- method:POST
- param:
  - cid 课程id
  - curPage 当前页码
  - data 发送的数据
- return:如果失败，从message中取出服务器返回的报错信息展示即可。

### 9.教师请求当前页面的数据

- [ ] 

- URL:${IP}:\${port}/\${projectName}/class/getCurStaDat
- method:GET
- param:
  - cid 课程id
  - curPage 当前页码
- return:如果失败，从message中取出服务器返回的报错信息展示即可，否则从object中取出数据。

```json

```

### 10.根据课程id获取总页数

- URL:${IP}:\${port}/\${projectName}/class/getPageNum
- method:GET
- param:
  - cid 课程id
- return:如果失败，从message中取出服务器返回的报错信息展示即可，否则从object中取出数据。

### 11.教师查看历史数据