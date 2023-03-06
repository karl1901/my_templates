<template>
  <div>
    <nav>
      <el-pagination
        background
        @current-change="changePage"
        @size-change="changeSize"
        :layout="layout"
        :page-sizes="sizes"
        :total="page.total"
        :page-count="page.pageCount"
        :page-size.sync="page.pageSize"
        :current-page.sync="page.pageNumber"
        :hide-on-single-page="true"
      ></el-pagination>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'Page',
  data() {
    return {};
  },
  props: {
    page: {
      default() {
        return {};
      }
    },
    layout: {
      default() {
        return 'total,sizes,prev,pager,next,jumper';
      }
    },
    sizes: {
      default() {
        return [5, 10, 20, 30];
      }
    }
  },
  methods: {
    changeSize() {
      this.$emit('page-change', this.page);
    },
    changePage() {
      this.$emit('page-change', this.page);
    }
  }
};
</script>
