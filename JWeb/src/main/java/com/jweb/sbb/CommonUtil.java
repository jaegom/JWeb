package com.jweb.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

/*
 * 타임리프는 백엔드에서 결과값을 계산(컴파일) 후 프론트에 전달
 * js 기반 라이브러리는 던져서 UI에서 계산
 */

@Component
public class CommonUtil {
	
	public String markdown(String markdown) {
		Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
		
	}
	
}
