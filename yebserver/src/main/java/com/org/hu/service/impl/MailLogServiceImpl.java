package com.org.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.mapper.MailLogMapper;
import com.org.hu.pojo.MailLog;
import com.org.hu.service.IMailLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@Service
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
