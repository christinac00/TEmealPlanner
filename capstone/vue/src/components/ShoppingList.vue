<template>
  <div>
    <!-- <input type="checkbox" id="Milk" value="Milk" v-model="checkedItems">
<label for="Milk">Milk</label>
<input type="checkbox" id="Eggs" value="Eggs" v-model="checkedItems">
<label for="Eggs">Eggs</label>
<input type="checkbox" id="Bread" value="Bread" v-model="checkedItems">
<label for="Bread">Bread</label> -->
<ul>
  <li>Eggs</li>
  <li>Milk</li>
  <li>Bread</li>
  <li>Avocado</li>
  <li>Bagels</li>
  <li>Yogurt</li>
  <li>Lettuce</li>
  <li>Cucumber</li>
  <li>Tomatoes</li>
  <li>Mayo</li>
  
</ul>
  </div>
</template>

<script>
export default {
name: "shopping-list"
}
</script>

<style>
ul {
  font-family: 'Hind', sans-serif;
  font-weight: 600;
  font-size: 1.25rem;
}

</style>