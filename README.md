# 项目介绍
  搭建一个可在线放映幻灯片的教育辅助工具。教师可以实时地把每页幻灯片推送给所有学生，同时系统会根据所有在线学生的面部表情对学生是否理解幻灯片内容进行分类，并把情绪分析的统计结果以图形的形式可视化、动态地展现给教师。使教师可以直观的了解当前页和整套幻灯片学生的理解情况，有助于教师对课堂教学的质量进行评估，进而有针对性地对教学内容进行调整。
  后端使用Hibernate,Spring boot搭建，前端使用Jquery搭建，数据库使用MySQL，测试工具主要使用JUnit。情绪分析模块调用Face++旷世的api，得到代表[愤怒,厌恶,恐惧,高兴,平静,伤心,惊讶]的7维向量，忽略平静维度，将剩余维度按照[-1,-1,-1,3,-1,1]进行线性组合，得到学生理解程度的评分score，设定阈值threshold=0,score>threshold则把对象分类为理解，否则分类为未理解。
  本项目旨在辅助课堂教学，解决课堂教学时学生反应过于平淡，因此难以对教学质量、教学难点进行有效评估，进而出现教学过程重点不明确，资源、时间浪费的问题。通过对学生表情的分析，教师可以更深层次地了解学生目前的学习状态，进而推测当前课堂教学的质量、教学的难点，提升课堂教学的效率和针对性。
# Github仓库地址
https://github.com/MickeyLLG/NjuvivoCtrli.git
# 项目访问地址
http://106.14.212.49:8091/login.html
