<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
<style>
body {
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji',
    'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';
}
.container {
  display: grid;
  grid-template-rows: 40px calc(100vh - 40px);
  grid-template-columns: 1fr 3fr;
  grid-template-areas:
    'boards header'
    'boards content';
}

.boardsList{
  grid-area: boards;
}

.routerView {
  display: flex;
  flex-wrap: wrap;
  overflow: auto;
  grid-area: content;
}
.top{
  background-color: lightseagreen;
  display: flex;
  align-items: center;
  justify-content: space-around;
  grid-area: header;
}

.loading {
  display: flex;
  justify-content: center;
  align-items: center;
}
.btn {
  display: inline-block;
  font-weight: 400;
  color: #212529;
  text-align: center;
  vertical-align: middle;
  border: 1px solid transparent;
  padding: .375rem .75rem;
  margin-right: 10px;
  margin-bottom: 5px;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: .25rem;
  cursor: pointer;
}