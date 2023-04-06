package com.ianjung.newapiex.newsapp.api

import com.ianjung.newapiex.newsapp.NewsResponse
import com.ianjung.newapiex.newsapp.Utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines") //우리는 headline news만 가져올것
    suspend fun getBreakingNews(
        //Suspend는 안에있는 함수들이 실행될때까지 다른 스레드를 멈춤
        //다 불러오지 못했는데 다른 작업이 데이터를 요청하면 에러를 불러올수있기때문에 suspend를 사용하면 안전하게 데이터를 가져옴
        @Query("country") //parameter를 넣어줍니다.
        countryCode:String = "us", //기본값으로 US
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey:String = API_KEY //편의를 위해 API_KEY를 constant 클래스에 모음
    ): Response<NewsResponse> //플러그인을 통해 만들어 주었던 데이터 클래스를 연결

    //두번째 엔드포인트는 everything을 써주었습니다. 위 방식과 동일합니다.
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey:String = API_KEY
    ):Response<NewsResponse>
}