def f(x,y):
    return x*y
print f(2,3)
g=lambda x,y:x*y
print g(2,3)
d=lambda x:x**2
print d
l=range(1,6)
print reduce(f, l)
ff=lambda x,y:x*y
print reduce(ff, l)