package com.vic.utils;

import com.vic.applib.utils.UIUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vic on 2016/6/29 0029.
 */
public class UIUtilTest {

    @Test
    public void testGetNumber() throws Exception {
        assertTrue(UIUtil.getNumber()==1);
    }
}