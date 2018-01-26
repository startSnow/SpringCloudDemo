URL与配置文件的映射关系如下：

    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties

上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。

我们可以尝试构造不同的url来访问不同的配置内容，比如：要访问config-label-test分支，didispace应用的prod环境，可以通过这个url：

http://localhost:7001/open/cloud.prod
http://localhost:7001/open/cloud.dev


http://localhost:7001/tj/dev
http://localhost:7001/tj/prod