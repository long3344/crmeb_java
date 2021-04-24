<template>
  <div class="divBox">
    <el-card class="box-card">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm">
        <el-form-item label="优惠劵名称" prop="name">
          <el-input v-model="ruleForm.name" style="width: 350px" placeholder="请输入优惠券名称"></el-input>
        </el-form-item>
        <el-form-item label="优惠劵类型">
          <el-radio-group v-model="ruleForm.type">
            <el-radio :label="1">天天可领</el-radio>
            <el-radio :label="2">限时秒杀</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="横幅图片" prop="bannerPic">
          <el-input v-model="ruleForm.bannerPic" style="width: 350px"></el-input>
        </el-form-item>
        <el-form-item label="图标" prop="icon">
          <el-input v-model="ruleForm.icon" style="width: 350px"></el-input>
        </el-form-item>
        <el-form-item label="优惠券领取地址" prop="url">
          <el-input v-model="ruleForm.url" type="textarea" :rows="3" style="width: 350px" placeholder="请输入领取地址"></el-input>
        </el-form-item>
        <el-form-item label="小程序设置" prop="minApp">
          <el-input v-model="ruleForm.minApp" type="textarea" :rows="3" style="width: 350px" placeholder="请设置小程序内容"></el-input>
        </el-form-item>
        <el-form-item label="发布数量" prop="sort">
          <el-input-number v-model="ruleForm.sort" :min="1"></el-input-number>
        </el-form-item>
        <el-form-item label="菜单id" prop="tabId">
          <el-input-number v-model="ruleForm.tabId" :min="1"></el-input-number>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="ruleForm.status">
            <el-radio :label="true">开启</el-radio>
            <el-radio :label="false">关闭</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button size="mini" type="primary" @click="submitForm('ruleForm')" :loading="loading">立即创建</el-button>
          <!--<el-button @click="resetForm('ruleForm')">重置</el-button>-->
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  import { couponSaveApi, couponInfoApi } from '@/api/marketing'
  import { categoryApi } from '@/api/store'
  export default {
    name: "creatCoupon",
    data() {
      return {
        loading: false,
        ruleForm: {
          name: '',
          type: 1,
          bannerPic: null,
          icon: null,
          minApp: null,
          sort: 1,
          tabId: 1,
          type: 2,
          url: '',
          status: true
        },
        isForeverTime: [],
        rules: {
          name: [
            { required: true, message: '请输入优惠券名称', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '请选优惠券类型', trigger: 'change' }
          ],
          bannerPic:  [
            { required: true, message: '请上传横幅图片', trigger: 'blur'}
          ],
          icon: [
            { required: true, message: '请上传图标', trigger: 'blur',}
          ],
          url: [
            { required: true, message: '请设置优惠券领取地址', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '请输入发布数量', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
           this.loading = true
            couponSaveApi(this.ruleForm).then(() => {
              this.$message.success("新增成功")
              this.loading = false
              setTimeout(() => {
                this.$router.push({ path: `/marketing/coupon/list` })
              }, 200);
            }).catch(() => {
              this.loading = false
            })
          } else {
            this.loading = false
            return false;
          }
        });
      },
    }
  }
</script>

<style scoped lang="scss">
  .pictrue{
    width: 60px;
    height: 60px;
    border: 1px dotted rgba(0,0,0,0.1);
    margin-right: 10px;
    position: relative;
    cursor: pointer;
    img{
      width: 100%;
      height: 100%;
    }
  }
  .btndel{
    position: absolute;
    z-index: 1;
    width :20px !important;
    height: 20px !important;
    left: 46px;
    top: -4px;
  }
</style>
