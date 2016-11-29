from numpy import *  
import matplotlib.pyplot as plt  
def loadDataSet(fileName, delim='\t'):  
    fr = open(fileName)  
    stringArr=[line.strip('\n').split(delim) for line in fr.readlines()]  
    fr.close()  
    datArr=[map(float,line) for line in stringArr]  
    return mat(datArr)  
def pca(dataMat, topNfeat=9999):  
    meanVals = mean(dataMat, axis=0)  
    meanRemoved = dataMat-meanVals  
    covMat=cov(meanRemoved, rowvar=0)  
    print covMat  
    eigVals, eigVects=linalg.eig(mat(covMat))  
    eigValInd=argsort(eigVals)  
    eigValInd=eigValInd[:-(topNfeat+1):-1]  
    redEigVects=eigVects[:,eigValInd]  
    lowDDataMat=meanRemoved*redEigVects  
    reconMat=(lowDDataMat*redEigVects.T)+meanVals  
    return lowDDataMat, reconMat  
dataMat=loadDataSet("C:/Users/xxw/Desktop/test.txt")  
low, rec=pca(dataMat,1)  
i=0  
while i<shape(dataMat)[0]:  
    print dataMat[i,:],"_",rec[i,:]  
    i=i+1  