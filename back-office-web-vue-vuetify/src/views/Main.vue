<template>
  <div>
    <v-row align="center">
      <v-col cols="6" align-self="start">
        <v-sheet min-height="300px" rounded="lg" class="ma-1 pa-1" color="grey lighten-2">
          <canvas id="pie-chart-area" style="display: block; height: 285px; width: 570px;" width="1140" height="570"
                  class="chartjs-render-monitor"></canvas>
        </v-sheet>
        <v-sheet min-height="400px" rounded="lg" class="ma-1 pa-1" color="grey lighten-2">
          <MainGrid v-bind="gridProps1" v-on="{addItem: changeGrid1Modal}"></MainGrid>
        </v-sheet>
      </v-col>
      <v-col cols="6" align-self="start">
        <v-sheet min-height="300px" rounded="lg" class="ma-1 pa-1" color="grey lighten-2">
          <canvas id="line-chart-area" style="display: block; height: 285px; width: 570px;" width="1140" height="570"
                  class="chartjs-render-monitor"></canvas>
        </v-sheet>
        <v-sheet min-height="400px" rounded="lg" class="ma-1 pa-1" color="grey lighten-2">
          <MainGrid v-bind="gridProps2" v-on="{addItem: changeGrid2Modal}"></MainGrid>
        </v-sheet>
      </v-col>
    </v-row>
    <Modal v-bind="grid1ModalProps" v-on="{closeModal: changeGrid1Modal}"></Modal>
    <Modal v-bind="grid2ModalProps" v-on="{closeModal: changeGrid2Modal}">
      <div slot="body">none</div>
    </Modal>
  </div>
</template>

<script>
import Modal from "@/components/Modal";
import Test from '@/data/main';
import Chart from 'chart.js';
import MainGrid from "@/components/MainGrid";


export default {
  mounted() {
    this.drawChart('pie-chart-area', this.pieChartConfig);
    this.drawChart('line-chart-area', this.lineChartConfig);
  },
  components: {
    Modal,
    MainGrid,
  },
  data() {
    return {
      gridProps1: {
        headers: Test.header1,
        items: Test.items1,
        itemsPerPage: 10,
      },
      gridProps2: {
        headers: Test.header2,
        items: Test.items2,
        itemsPerPage: 10,
        // topUse: true,
      },
      grid1ModalProps: {
        isOpen: false,
        title: 'test1 modal',
      },
      grid2ModalProps: {
        isOpen: false,
        title: 'test2 modal',
      },
      pieChartConfig: {
        type: 'pie',
        data: {
          datasets: [{
            data: [
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
            ],
            backgroundColor: [
              'red',
              'orange',
              'yellow',
              'green',
              'blue',
            ],
            label: 'Dataset 1'
          }],
          labels: [
            'Red',
            'Orange',
            'Yellow',
            'Green',
            'Blue'
          ]
        },
        options: {
          responsive: true
        }
      },
      lineChartConfig: {
        months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
          datasets: [{
            label: 'My First dataset',
            backgroundColor: 'red',
            borderColor: 'red',
            data: [
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor()
            ],
            fill: false,
          }, {
            label: 'My Second dataset',
            fill: false,
            backgroundColor: 'blue',
            borderColor: 'blue',
            data: [
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor(),
              this.randomScalingFactor()
            ],
          }]
        },
        options: {
          responsive: true,
          title: {
            display: true,
            text: 'Chart.js Line Chart'
          },
          tooltips: {
            mode: 'index',
            intersect: false,
          },
          hover: {
            mode: 'nearest',
            intersect: true
          },
          scales: {
            xAxes: [{
              display: true,
              scaleLabel: {
                display: true,
                labelString: 'Month'
              }
            }],
            yAxes: [{
              display: true,
              scaleLabel: {
                display: true,
                labelString: 'Value'
              }
            }]
          }
        }
      }
    }
  },
  methods: {
    changeGrid1Modal() {
      this.grid1ModalProps.isOpen = !this.grid1ModalProps.isOpen
    },
    changeGrid2Modal() {
      this.grid2ModalProps.isOpen = !this.grid2ModalProps.isOpen
    },
    getHealth(healthStatus) {
      if (healthStatus === 'a') return 'red'
      else if (healthStatus === 'b') return 'orange'
      else if (healthStatus === 'c') return 'yellow'
      else if (healthStatus === 'd') return 'green'
      else return 'blue'
    },
    randomScalingFactor() {
      return Math.round(Math.random() * 100);
    },
    drawChart(chartId, config) {
      const ctx = document.getElementById(chartId).getContext('2d');
      new Chart(ctx, config);
    },
  }
  ,
}
</script>

<style scoped>

</style>
