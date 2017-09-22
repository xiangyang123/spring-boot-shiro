package com.neo.filter;

/**
 * Created by zouxiang on 2017/9/22.
 */
/**

 * druid过滤器.

 * @author Administrator

 *

 */

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",

        initParams={

                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源

        }

)

public class DruidStatFilter extends WebStatFilter {



        }

