<template>
    <div>
        <a-spin>
            <a-icon slot="indicator" type="loading" class="loadding" spin/>
        </a-spin>
    </div>
</template>

<script>
export default {
    data() {
        return {

        };
    },
    mounted() {
        window.setTimeout(() => {
            this.$router.push({name: 'Logon'});
        }, 1000)
    }
}
</script>