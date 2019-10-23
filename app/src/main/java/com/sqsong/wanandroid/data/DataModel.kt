package com.sqsong.wanandroid.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

abstract class BaseBean<T : Any?> {
    val errorCode: Int = 0
    val errorMsg: String? = null
    abstract var data: T?
}

abstract class GankBasedBean<T : Any?> {
    val error: Boolean = false
    abstract var results: T?
}

data class BaseData(override var data: Any?) : BaseBean<Any?>()

/********************* Begin: Login Data ***********************/

data class LoginBean(override var data: LoginData?) : BaseBean<LoginData?>()

data class LoginData(val id: Int,
                     val username: String)

/********************* End: Login Data *************************/

/********************* Begin: Home banner bean ***********************/
data class HomeBannerBean(override var data: List<HomeBannerData>?) : BaseBean<List<HomeBannerData>>()

data class HomeBannerData(val desc: String,
                          val id: Int,
                          val imagePath: String,
                          val isVisible: Int,
                          val order: Int,
                          val title: String,
                          val type: Int,
                          val url: String)
/********************* End: Home banner bean ***********************/

/********************* Begin: Home list bean **********************/
data class HomeItemBean(override var data: HomeItemData?) : BaseBean<HomeItemData>()

data class HomeItemData(val curPage: Int,
                        var datas: MutableList<HomeItem>,
                        val offset: Int,
                        val over: Boolean,
                        val pageCount: Int,
                        val size: Int,
                        val total: Int)

data class HomeItem(val apkLink: String,
                    val author: String,
                    val chapterId: Int,
                    val chapterName: String,
                    var collect: Boolean,
                    val courseId: Int,
                    val originId: Int,
                    val desc: String,
                    val envelopePic: String,
                    val fresh: Boolean,
                    val id: Int,
                    val link: String,
                    val niceDate: String,
                    val origin: String,
                    val projectLink: String,
                    val publishTime: Long,
                    val superChapterId: Int,
                    val superChapterName: String,
                    val title: String,
                    val shareUser: String?,
                    val userId: Int,
                    val visible: Int,
                    var zan: Int)
/********************* End: Home list bean **********************/

/********************* Start: Knowledge bean **********************/
data class KnowledgeBean(override var data: List<KnowledgeData>?) : BaseBean<List<KnowledgeData>>()

@Parcelize
data class KnowledgeData(val children: List<KnowledgeData>,
                         val courseId: Int,
                         val id: Int,
                         val name: String,
                         val order: Int,
                         val parentChapterId: Int,
                         val userControlSetTop: Boolean,
                         val visible: Int) : Parcelable
/********************* End: Knowledge bean **********************/

/********************* Start: Navigation bean **********************/
data class NavigationBean(override var data: List<NavigationData>?) : BaseBean<List<NavigationData>>()

data class NavigationData(val articles: List<HomeItem>,
                          val cid: Int,
                          val name: String)
/********************* End: Navigation bean ************************/

/********************* Start: Hot search bean **********************/
data class HotSearchBean(override var data: List<HotSearchData>?) : BaseBean<List<HotSearchData>>()

data class HotSearchData(val id: Int,
                         val link: String,
                         val name: String,
                         val order: Int,
                         val visible: Int)
/********************* End: Hot search bean **********************/

/********************* Begin: Welfare Data ***********************/
data class WelfareBean(override var results: List<WelfareData>?) : GankBasedBean<List<WelfareData>>()

@Parcelize
data class WelfareData(val _id: String,
                       val createAt: String?,
                       val desc: String?,
                       val publishedAt: String?,
                       val source: String?,
                       val type: String?,
                       val url: String,
                       val used: Boolean,
                       val who: String?) : Parcelable
/********************* Begin: Welfare Data ***********************/

/********************* Begin: Scanning Result ***********************/
@Parcelize
data class ScanResult(val resultText: String?,
                      val format: String?,
                      val type: String?,
                      val time: String?,
                      val bitmapByteArray: ByteArray?) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ScanResult

        if (resultText != other.resultText) return false
        if (format != other.format) return false
        if (type != other.type) return false
        if (time != other.time) return false
        if (bitmapByteArray != null) {
            if (other.bitmapByteArray == null) return false
            if (!bitmapByteArray.contentEquals(other.bitmapByteArray)) return false
        } else if (other.bitmapByteArray != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = resultText?.hashCode() ?: 0
        result = 31 * result + (format?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (time?.hashCode() ?: 0)
        result = 31 * result + (bitmapByteArray?.contentHashCode() ?: 0)
        return result
    }

}
/********************* Begin: Scanning Result ***********************/