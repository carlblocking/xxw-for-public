#-*-coding:utf-8-*-
def tell(name='name',age=0):
    print "name:%s" % name
    print "age:%s" % age
    
d={'name':'carl','age':55}
tell(**d)

def fd(x,*args):
    print x
    print args

fd(1,23,56,5)
