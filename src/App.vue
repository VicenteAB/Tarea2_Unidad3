<template>
    <div>
        <Car></Car>
    </div>
  </template>
  
  <script>
  import Car from './views/Car.vue'
  
  export default {
    name: 'App',
    components: {
        Car,
    }
  }
  </script>
  
  <style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
  </style>