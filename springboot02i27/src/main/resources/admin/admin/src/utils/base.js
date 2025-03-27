const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot02i27/",
            name: "springboot02i27",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot02i27/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "日常办公用品直售推荐系统的设计与实现"
        } 
    }
}
export default base
