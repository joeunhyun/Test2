package org.example.springboot.domain.posts;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate //entity 생성시 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 entity 값 변경시 시간 자동 저장
    private LocalDateTime modifiedDate;

}
