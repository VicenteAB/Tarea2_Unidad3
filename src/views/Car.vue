<template>
    <div id="app">
        <form @submit.prevent="generarAutos">
            <label for="cantidad">Cantidad:</label>
            <input type="number" id="cantidad" v-model="cantidad" required>
            <button type="submit">Generar</button>
        </form>
        <br>
        <form @submit.prevent="filtrarAutos">
            <label for="precio">Precio: </label>
            <input type="number" id="precio" v-model="precio">&nbsp;
            <label for="color">Color: </label>
            <input type="text" id="color" v-model="color">&nbsp;
            <label for="tipo">Tipo: </label>
            <input type="text" id="tipo" v-model="tipo">&nbsp;
            <button type="submit">Filtrar</button>
        </form>

        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Marca</th>
                    <th>Año</th>
                    <th>Color</th>
                    <th>Precio</th>
                    <th>Turbo</th>
                    <th>Tipo</th>
                    <th>Motor</th>
                    <th>Cabinas</th>
                    <th>Sunroof</th>
                    <th>Popularidad</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="auto in autos" :key="auto.id">
                    <td>{{ auto.id }}</td>
                    <td>{{ auto.marca }}</td>
                    <td>{{ auto.año }}</td>
                    <td>{{ auto.color }}</td>
                    <td>{{ auto.precio }}</td>
                    <td>{{ auto.turbo }}</td>
                    <td>{{ auto.tipo }}</td>
                    <td>{{ auto.motor }}</td>
                    <td>{{ auto.cabinas }}</td>
                    <td>{{ auto.sunroof }}</td>
                    <td>{{ auto.popularidad }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
  
<script>
export default {
    name: "CarS",
    data() {
        return {
            cantidad: null,
            autos: [],
            color: null,
            tipo: null,
            precio: null,
        };
    },
    methods: {
        generarAutos() {
            fetch(`http://localhost:8080/automoviles/generar/${this.cantidad}`)
                .then((response) => response.json())
                .then((autos) => {
                    this.autos = autos;
                });
        },
        filtrarAutos() {
            const params = new URLSearchParams();
            if (this.precio) {
                params.append('precio', this.precio);
            }
            if (this.color) {
                params.append('color', this.color);
            }
            if (this.tipo) {
                params.append('tipo', this.tipo);
            }

            fetch(`http://localhost:8080/automoviles/filtrar?${params.toString()}`)
                .then((response) => response.json())
                .then((autos) => {
                    this.autos = autos;
                });
        },
    },
};
</script>

<style>
table {
    border-collapse: collapse;
    width: 100%;
    margin-top: 1em;
}

th,
td {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
}

th {
    background-color: #f2f2f2;
    color: #333;
}

.contenedor {
    display: flex;
    flex-wrap: wrap;
}

.contenedor>div {
    flex: 1;
    margin-right: 10px;
}
</style>