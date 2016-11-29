from __future__ import division
# 
# def jia(x,y):
#     return x+y
# 
# def jian(x,y):
#     return x-y
# 
# def cheng(x,y):
#     return x*y
# 
# def chu(x,y):
#     return x/y
# 
# operator={"+":jia,"-":jian,"*":cheng,"/":chu}
# print operator["/"](3,2)
# print jia(3, 2)
# def f(o):
#     return operator.get(o)(3,2)
# print f("-")

x=1
y=2
operator="/"
result={
    "+":x+y,
    "-":x-y,
    "*":x*y,
    "/":x/y,
    }
print result.get(operator)
    