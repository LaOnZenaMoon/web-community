<template>
  <div class="main main-raised">
    <div class="md-layout">
      <div class="md-layout-item">
        <b-table striped hover :items="items"></b-table>
      </div>
    </div>
  </div>
</template>

<script>


export default {
  components: {},
  props: {},
  data() {
    return {
      items: [
        { age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
        { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        { age: 89, first_name: 'Geneva', last_name: 'Wilson' },
        { age: 38, first_name: 'Jami', last_name: 'Carney' }
      ],
    };
  },
  methods: {},
  computed: {},
};
</script>

<style scoped>

</style>
