<template>
    <div>
        <a-card title="疫情最新动态" :bordered="false">
            <a-table
                :columns="columns"
                :row-key="record => record.id"
                :data-source="data"
                :pagination="pagination"
                :loading="loading"
                @change="handleTableChange"
                size="small"
            >
            </a-table>
        </a-card>

        <a-card title="入境人员信息统计" :bordered="false" style="margin-top:14px">
            <a-row>
                <a-col :span="8">
                    <div id="patientL2FromCity" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
                <a-col :span="8">
                    <div id="patientL2Gender" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
                <a-col :span="8">
                    <div id="patientL2Age" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
            </a-row>
        </a-card>
        
        <a-card title="中高风险接触人员信息统计" :bordered="false" style="margin-top:14px">
            <a-row>
                <a-col :span="12" style="text-align:center">
                    <div id="patientL3Gender" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
                <a-col :span="12" style="text-align:center">
                    <div id="patientL3Age" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
            </a-row>
        </a-card>

        <a-card title="确诊人员信息统计" :bordered="false" style="margin-top:14px">
            <a-row>
                <a-col :span="12" style="text-align:center">
                    <div id="patientL1Gender" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
                <a-col :span="12" style="text-align:center">
                    <div id="patientL1Age" :style="{width: '100%', height: '350px'}"></div>
                </a-col>
            </a-row>
        </a-card>
    </div>
</template>

<script>

import {selectNews, selectCountByFromCity}  from '@/api/HttpAPI';

var echarts = require('echarts');

export default {
    data() {
        return {
            data: [],
            pagination: {
                current: 1
            },
            loading: false,
            columns,
            patientL2FromCityXData: [],
            patientL2FromCityYData: [],
            patientL2CityPieData: [],
            patientL2AgePieData: [],

            patientL3FromCityXData: [],
            patientL3FromCityYData: [],
            patientL3CityPieData: [],
            patientL3AgePieData: [],

            patientL1FromCityXData: [],
            patientL1FromCityYData: [],
            patientL1CityPieData: [],
            patientL1AgePieData: []
        }
    },

    mounted() {
        this.fetch();

        selectCountByFromCity().then(resp => {
            console.log(resp.data);

            let index = 0;
            let patientL2FromCityData = resp.data.patientL2FromCity;
            for (index in patientL2FromCityData) {
                this.patientL2FromCityXData.push(patientL2FromCityData[index].fromCity);
                this.patientL2FromCityYData.push(patientL2FromCityData[index].count);
            }
            this.drawPatientL2FromCity();

            index = 0;
            let patientL2GenderData = resp.data.patientL2Gender;
            let genderData = {};
            for (index in patientL2GenderData) {
                genderData = {};
                genderData.value = patientL2GenderData[index].count;
                genderData.name = patientL2GenderData[index].gender;
                this.patientL2CityPieData.push(genderData);
            }
            this.drawPatientL2Gender();


            let patientL2AgeData = resp.data.patientL2Age;
            this.patientL2AgePieData = [
                {value: patientL2AgeData[0].age0020, name: '0~20'},
                {value: patientL2AgeData[0].age2040, name: '20~40'},
                {value: patientL2AgeData[0].age4060, name: '40~60'},
                {value: patientL2AgeData[0].age6080, name: '60~80'},
                {value: patientL2AgeData[0].age80150, name: '80~150'}
            ];
            this.drawPatientL2Age();

            index = 0;
            let patientL3GenderData = resp.data.patientL3Gender;
            genderData = {};
            for (index in patientL3GenderData) {
                genderData = {};
                genderData.value = patientL3GenderData[index].count;
                genderData.name = patientL3GenderData[index].gender;
                this.patientL3CityPieData.push(genderData);
            }
            this.drawPatientL3Gender();


            let patientL3AgeData = resp.data.patientL3Age;
            this.patientL3AgePieData = [
                {value: patientL3AgeData[0].age0030, name: '0~20'},
                {value: patientL3AgeData[0].age3040, name: '20~40'},
                {value: patientL3AgeData[0].age4060, name: '40~60'},
                {value: patientL3AgeData[0].age6080, name: '60~80'},
                {value: patientL3AgeData[0].age80150, name: '80~150'}
            ];
            this.drawPatientL3Age();

            index = 0;
            let patientL1GenderData = resp.data.patientL1Gender;
            genderData = {};
            for (index in patientL1GenderData) {
                genderData = {};
                genderData.value = patientL1GenderData[index].count;
                genderData.name = patientL1GenderData[index].gender;
                this.patientL1CityPieData.push(genderData);
            }
            this.drawPatientL1Gender();


            let patientL1AgeData = resp.data.patientL1Age;
            this.patientL1AgePieData = [
                {value: patientL1AgeData[0].age0010, name: '0~20'},
                {value: patientL1AgeData[0].age1040, name: '20~40'},
                {value: patientL1AgeData[0].age4060, name: '40~60'},
                {value: patientL1AgeData[0].age6080, name: '60~80'},
                {value: patientL1AgeData[0].age80150, name: '80~150'}
            ];
            this.drawPatientL1Age();
        });
    },

    methods: {
        handleTableChange(pagination) {
            const pager = {...this.pagination};
            pager.current = pagination.current;
            this.pagination = pager;
            this.fetch();
        },

        fetch() {
            this.loading = true;
            const params = {
                currPage: this.pagination.current
            };
            selectNews(params).then(resp => {
                const data = resp.data;
                const pagination = { ...this.pagination };
                pagination.total = data.count;
                this.loading = false;
                this.data = data.data;
                this.pagination = pagination;
            });
        },

        drawPatientL2Age() {
            var myChart = echarts.init(document.getElementById('patientL2Age'));
            myChart.setOption({
                title: {
                    text: '年龄占比',
                    left: 'left',
                    top: 100,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    top: '5%',
                    left: 'center'
                },
                series: [
                    {
                        name: '年龄占比',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: this.patientL2AgePieData,
                        color: ['#1E90FF', '#EEE']
                    }
                ]
            });
        },

        drawPatientL2Gender () {
            var myChart = echarts.init(document.getElementById('patientL2Gender'));
            myChart.setOption({
                title: {
                    text: '性别占比',
                    left: 'left',
                    top: 100,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    top: '5%',
                    left: 'center'
                },
                series: [
                    {
                        name: '性别占比',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: this.patientL2CityPieData,
                        color: ['#1E90FF', '#EEE']
                    }
                ]
            });
        },

        drawPatientL2FromCity () {
            var myChart = echarts.init(document.getElementById('patientL2FromCity'));
            myChart.setOption({
                title: {
                    text: '来源地占比',
                    left: 'left',
                    top: 0,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {},
                    xAxis: {
                    data: this.patientL2FromCityXData
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: this.patientL2FromCityYData,
                }],
                color: ['#1E90FF']
            });
        },

        drawPatientL3Age() {
            var myChart = echarts.init(document.getElementById('patientL3Age'));
            myChart.setOption({
                title: {
                    text: '年龄占比',
                    left: 'left',
                    top: 100,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    top: '5%',
                    left: 'center'
                },
                series: [
                    {
                        name: '年龄占比',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: this.patientL3AgePieData,
                        color: ['#1E90FF', '#EEE']
                    }
                ]
            });
        },

        drawPatientL3Gender () {
            var myChart = echarts.init(document.getElementById('patientL3Gender'));
            myChart.setOption({
                title: {
                    text: '性别占比',
                    left: 'left',
                    top: 100,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    top: '5%',
                    left: 'center'
                },
                series: [
                    {
                        name: '性别占比',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: this.patientL3CityPieData,
                        color: ['#1E90FF', '#EEE']
                    }
                ]
            });
        },

        drawPatientL1Age() {
            var myChart = echarts.init(document.getElementById('patientL1Age'));
            myChart.setOption({
                title: {
                    text: '年龄占比',
                    left: 'left',
                    top: 100,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    top: '5%',
                    left: 'center'
                },
                series: [
                    {
                        name: '年龄占比',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: this.patientL1AgePieData,
                        color: ['#1E90FF', '#EEE']
                    }
                ]
            });
        },

        drawPatientL1Gender () {
            var myChart = echarts.init(document.getElementById('patientL1Gender'));
            myChart.setOption({
                title: {
                    text: '性别占比',
                    left: 'left',
                    top: 100,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    top: '5%',
                    left: 'center'
                },
                series: [
                    {
                        name: '性别占比',
                        type: 'pie',
                        radius: ['40%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '40',
                                fontWeight: 'bold'
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        data: this.patientL1CityPieData,
                        color: ['#1E90FF', '#EEE']
                    }
                ]
            });
        },
    }
}

const columns = [{
    title: '标题',
    dataIndex: 'title',
}, {
    title: '内容',
    dataIndex: 'content'
}, {
    title: '发布人',
    dataIndex: 'createUser'
}, {
    title: '发布时间',
    dataIndex: 'createTime',
    customRender: (value) => {
        let date = new Date(value);
        return date.toLocaleDateString();
    }
}];

</script>
