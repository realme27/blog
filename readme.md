语法优雅：ognl、springEL
支持HTML5
thymeleaf：标准方言
<span th:text=""></span>
<span></span>
--
#变量表达式
${...}
<span th:text="${book.author.name}"></span>
#消息表达式
#{...}
<span th:text="#{}"></span>
--文本外部化、文本国际化i18n
#选择表达式
<-- {...} !-->
--<div>
	<span></span>
--</div>
当前选择的对象
#连接表达式
{...}
#分段表达式
#th:insert th:replace
#字面量
th:text="2013"
#算术操作--
> < 
无操作
_
#设置属性值
#迭代器 th:each
数组 -- list map
状态变量 
index count size current even/odd(奇数/偶数) first last
##条件语句
th:switch
th:case
####模板布局
th:insert 插入标签
th:replace 替换标签
th:include 只要内容不需要外面标签
---
属性优先级