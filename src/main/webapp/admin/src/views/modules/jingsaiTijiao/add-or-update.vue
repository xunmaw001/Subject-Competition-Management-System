<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='jingsai'">
                    <el-form-item class="select" v-if="type!='info'"  label="竞赛项目信息" prop="jingsaiId">
                        <el-select v-model="ruleForm.jingsaiId" :disabled="ro.jingsaiId" filterable placeholder="请选择竞赛项目信息" @change="jingsaiChange">
                            <el-option
                                    v-for="(item,index) in jingsaiOptions"
                                    v-bind:key="item.id"
                                    :label="item.jingsaiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛名称" prop="jingsaiName">
                        <el-input v-model="jingsaiForm.jingsaiName"
                                  placeholder="竞赛名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛名称" prop="jingsaiName">
                            <el-input v-model="ruleForm.jingsaiName"
                                      placeholder="竞赛名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛编号" prop="jingsaiUuidNumber">
                        <el-input v-model="jingsaiForm.jingsaiUuidNumber"
                                  placeholder="竞赛编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛编号" prop="jingsaiUuidNumber">
                            <el-input v-model="ruleForm.jingsaiUuidNumber"
                                      placeholder="竞赛编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='jingsai' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jingsaiPhoto" label="竞赛照片" prop="jingsaiPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (jingsaiForm.jingsaiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jingsaiPhoto" label="竞赛照片" prop="jingsaiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.jingsaiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛类型" prop="jingsaiValue">
                        <el-input v-model="jingsaiForm.jingsaiValue"
                                  placeholder="竞赛类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛类型" prop="jingsaiValue">
                            <el-input v-model="ruleForm.jingsaiValue"
                                      placeholder="竞赛类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsaiYuyue'">
                    <el-form-item class="select" v-if="type!='info'"  label="竞赛报名" prop="jingsaiYuyueId">
                        <el-select v-model="ruleForm.jingsaiYuyueId" :disabled="ro.jingsaiYuyueId" filterable placeholder="请选择竞赛报名" @change="jingsaiYuyueChange">
                            <el-option
                                    v-for="(item,index) in jingsaiYuyueOptions"
                                    v-bind:key="item.id"
                                    :label="item.jingsaiYuyueUuidNumber"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='jingsaiYuyue' ">
                    <el-form-item class="input" v-if="type!='info'"  label="报名唯一编号" prop="jingsaiYuyueUuidNumber">
                        <el-input v-model="jingsaiYuyueForm.jingsaiYuyueUuidNumber"
                                  placeholder="报名唯一编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报名唯一编号" prop="jingsaiYuyueUuidNumber">
                            <el-input v-model="ruleForm.jingsaiYuyueUuidNumber"
                                      placeholder="报名唯一编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsaiYuyue' ">
                    <el-form-item class="input" v-if="type!='info'"  label="报名理由" prop="jingsaiYuyueText">
                        <el-input v-model="jingsaiYuyueForm.jingsaiYuyueText"
                                  placeholder="报名理由" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报名理由" prop="jingsaiYuyueText">
                            <el-input v-model="ruleForm.jingsaiYuyueText"
                                      placeholder="报名理由" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsaiYuyue' ">
                    <el-form-item class="input" v-if="type!='info'"  label="报名状态" prop="jingsaiYuyueYesnoValue">
                        <el-input v-model="jingsaiYuyueForm.jingsaiYuyueYesnoValue"
                                  placeholder="报名状态" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报名状态" prop="jingsaiYuyueYesnoValue">
                            <el-input v-model="ruleForm.jingsaiYuyueYesnoValue"
                                      placeholder="报名状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsaiYuyue' ">
                    <el-form-item class="input" v-if="type!='info'"  label="审核回复" prop="jingsaiYuyueYesnoText">
                        <el-input v-model="jingsaiYuyueForm.jingsaiYuyueYesnoText"
                                  placeholder="审核回复" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="审核回复" prop="jingsaiYuyueYesnoText">
                            <el-input v-model="ruleForm.jingsaiYuyueYesnoText"
                                      placeholder="审核回复" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsaiYuyue' ">
                    <el-form-item class="input" v-if="type!='info'"  label="审核时间" prop="jingsaiYuyueShenheTime">
                        <el-input v-model="jingsaiYuyueForm.jingsaiYuyueShenheTime"
                                  placeholder="审核时间" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="审核时间" prop="jingsaiYuyueShenheTime">
                            <el-input v-model="ruleForm.jingsaiYuyueShenheTime"
                                      placeholder="审核时间" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='laoshi'">
                    <el-form-item class="select" v-if="type!='info'"  label="老师" prop="laoshiId">
                        <el-select v-model="ruleForm.laoshiId" :disabled="ro.laoshiId" filterable placeholder="请选择老师" @change="laoshiChange">
                            <el-option
                                    v-for="(item,index) in laoshiOptions"
                                    v-bind:key="item.id"
                                    :label="item.laoshiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='laoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="老师姓名" prop="laoshiName">
                        <el-input v-model="laoshiForm.laoshiName"
                                  placeholder="老师姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="老师姓名" prop="laoshiName">
                            <el-input v-model="ruleForm.laoshiName"
                                      placeholder="老师姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='laoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="老师手机号" prop="laoshiPhone">
                        <el-input v-model="laoshiForm.laoshiPhone"
                                  placeholder="老师手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="老师手机号" prop="laoshiPhone">
                            <el-input v-model="ruleForm.laoshiPhone"
                                      placeholder="老师手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='laoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="老师身份证号" prop="laoshiIdNumber">
                        <el-input v-model="laoshiForm.laoshiIdNumber"
                                  placeholder="老师身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="老师身份证号" prop="laoshiIdNumber">
                            <el-input v-model="ruleForm.laoshiIdNumber"
                                      placeholder="老师身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='laoshi' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.laoshiPhoto" label="老师头像" prop="laoshiPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (laoshiForm.laoshiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.laoshiPhoto" label="老师头像" prop="laoshiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.laoshiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='laoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="老师邮箱" prop="laoshiEmail">
                        <el-input v-model="laoshiForm.laoshiEmail"
                                  placeholder="老师邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="老师邮箱" prop="laoshiEmail">
                            <el-input v-model="ruleForm.laoshiEmail"
                                      placeholder="老师邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="yonghuIdNumber">
                        <el-input v-model="yonghuForm.yonghuIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户身份证号" prop="yonghuIdNumber">
                            <el-input v-model="ruleForm.yonghuIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户邮箱" prop="yonghuEmail">
                        <el-input v-model="yonghuForm.yonghuEmail"
                                  placeholder="用户邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户邮箱" prop="yonghuEmail">
                            <el-input v-model="ruleForm.yonghuEmail"
                                      placeholder="用户邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报名唯一编号" prop="jingsaiTijiaoUuidNumber">
                       <el-input v-model="ruleForm.jingsaiTijiaoUuidNumber"
                                 placeholder="报名唯一编号" clearable  :readonly="ro.jingsaiTijiaoUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报名唯一编号" prop="jingsaiTijiaoUuidNumber">
                           <el-input v-model="ruleForm.jingsaiTijiaoUuidNumber"
                                     placeholder="报名唯一编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="jingsaiId" name="jingsaiId" type="hidden">
            <input id="laoshiId" name="laoshiId" type="hidden">
            <input id="jingsaiYuyueId" name="jingsaiYuyueId" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="内容" prop="jingsaiTijiaoText">
                        <el-input type="textarea"  :readonly="ro.jingsaiTijiaoText" v-model="ruleForm.jingsaiTijiaoText" placeholder="内容"></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jingsaiTijiaoText" label="内容" prop="jingsaiTijiaoText">
                            <span v-html="ruleForm.jingsaiTijiaoText"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jingsaiShangchuanFile" label="竞赛项目上传" prop="jingsaiShangchuanFile">
                        <file-upload
                                tip="点击上传竞赛项目上传"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.jingsaiShangchuanFile?$base.url+ruleForm.jingsaiShangchuanFile:''"
                                @change="jingsaiShangchuanFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.jingsaiShangchuanFile" label="竞赛项目上传" prop="jingsaiShangchuanFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="$base.url+ruleForm.jingsaiShangchuanFile"  >竞赛项目上传下载</a>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jingsaiTijiaoYesnoTypes" label="提交状态" prop="jingsaiTijiaoYesnoTypes">
                        <el-input v-model="ruleForm.jingsaiTijiaoYesnoValue" placeholder="提交状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="竞赛项目评分" prop="jingsaiTijiaoPigai">
                       <el-input v-model="ruleForm.jingsaiTijiaoPigai"
                                 placeholder="竞赛项目评分" clearable  :readonly="ro.jingsaiTijiaoPigai"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="竞赛项目评分" prop="jingsaiTijiaoPigai">
                           <el-input v-model="ruleForm.jingsaiTijiaoPigai"
                                     placeholder="竞赛项目评分" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                jingsaiForm: {},
                jingsaiYuyueForm: {},
                laoshiForm: {},
                yonghuForm: {},
                ro:{
                    jingsaiTijiaoUuidNumber: false,
                    jingsaiId: false,
                    laoshiId: false,
                    jingsaiYuyueId: false,
                    yonghuId: false,
                    jingsaiTijiaoText: false,
                    jingsaiShangchuanFile: false,
                    jingsaiTijiaoYesnoTypes: false,
                    jingsaiTijiaoPigai: false,
                    insertTime: false,
                },
                ruleForm: {
                    jingsaiTijiaoUuidNumber: new Date().getTime(),
                    jingsaiId: '',
                    laoshiId: '',
                    jingsaiYuyueId: '',
                    yonghuId: '',
                    jingsaiTijiaoText: '',
                    jingsaiShangchuanFile: '',
                    jingsaiTijiaoYesnoTypes: '',
                    jingsaiTijiaoPigai: '',
                    insertTime: '',
                },
                jingsaiTijiaoYesnoTypesOptions : [],
                jingsaiOptions : [],
                jingsaiYuyueOptions : [],
                laoshiOptions : [],
                yonghuOptions : [],
                rules: {
                   jingsaiTijiaoUuidNumber: [
                              { required: true, message: '报名唯一编号不能为空', trigger: 'blur' },
                          ],
                   jingsaiId: [
                              { required: true, message: 'jingsai不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   laoshiId: [
                              { required: true, message: '老师不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiYuyueId: [
                              { required: true, message: '竞赛报名不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiTijiaoText: [
                              { required: true, message: '内容不能为空', trigger: 'blur' },
                          ],
                   jingsaiShangchuanFile: [
                              { required: true, message: '竞赛项目上传不能为空', trigger: 'blur' },
                          ],
                   jingsaiTijiaoYesnoTypes: [
                              { required: true, message: '提交状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiTijiaoPigai: [
                              { required: true, message: '竞赛项目评分不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '竞赛项目提交时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jingsai_tijiao_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiTijiaoYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `jingsai/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.jingsaiOptions = data.data.list;
            }
         });
         this.$http({
             url: `jingsaiYuyue/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.jingsaiYuyueOptions = data.data.list;
            }
         });
         this.$http({
             url: `laoshi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.laoshiOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            jingsaiChange(id){
                this.$http({
                    url: `jingsai/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiForm = data.data;
                    }
                });
            },
            jingsaiYuyueChange(id){
                this.$http({
                    url: `jingsaiYuyue/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiYuyueForm = data.data;
                    }
                });
            },
            laoshiChange(id){
                this.$http({
                    url: `laoshi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.laoshiForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `jingsaiTijiao/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.jingsaiChange(data.data.jingsaiId)
                        _this.jingsaiYuyueChange(data.data.jingsaiYuyueId)
                        _this.laoshiChange(data.data.laoshiId)
                        _this.yonghuChange(data.data.yonghuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`jingsaiTijiao/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.jingsaiTijiaoCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.jingsaiTijiaoCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            jingsaiShangchuanFileUploadChange(fileUrls){
                this.ruleForm.jingsaiShangchuanFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

