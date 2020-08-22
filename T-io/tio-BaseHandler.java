package com.kevin.tio.common;

import java.nio.ByteBuffer;

import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.AioHandler;
/**
 * ����Handler
 * �ͻ��˷���˱�/���뷽ʽһ��
 * @author	KevinBlandy
 * @version	1.0
 * @date	2017��5��2�� ����10:57:21
 */
public abstract class BaseHandler implements AioHandler<Object,DataPacket,Object>{
	
	/**
	 * ���ݽ���
	 */
	@Override
	public ByteBuffer encode(DataPacket packet, GroupContext<Object, DataPacket, Object> groupContext,ChannelContext<Object, DataPacket, Object> channelContext) {
		byte[] data = packet.getData();							//��ȡ������
		int dataLength = data.length;							//��ȡ���ݳ���	
		int length = DataPacket.DATA_LENGTH + dataLength;		//��������ܳ���
		ByteBuffer byteBuffer = ByteBuffer.allocate(length);	//����Buffer
		byteBuffer.putInt(dataLength);							//д���ͷ��Ϣ(���ݳ���)
		byteBuffer.put(data);									//д������
		return byteBuffer;	
	}
	
	/**
	 * ���ݱ���
	 */
	@Override
	public DataPacket decode(ByteBuffer buffer, ChannelContext<Object, DataPacket, Object> channelContext)throws AioDecodeException {
	    //�ɶ������ܳ���
	    int remaining = buffer.remaining();
		if(remaining < DataPacket.DATA_LENGTH){
			//���ʧ��,����null
			return null;
		}
		//��ȡ��Ϣ�峤��
		int dataLength = buffer.getInt();
		if(dataLength < 0){
			//���ݸ�ʽ����ȷ,�׳��쳣
			 throw new AioDecodeException("bodyLength [" + dataLength + "] is not right, remote:" + channelContext.getClientNode());
		}
		int length = DataPacket.DATA_LENGTH + dataLength;		//���������ܳ���(��Ϣͷ���� + ��Ϣ�峤��)
		if(remaining < length){
			//���ʧ��
			return null;
		}
		//����ɹ�
		DataPacket dataPacket = new DataPacket();
		if(dataLength > 0){
			//�������ݴ���
			byte[] data = new byte[dataLength];
			buffer.get(data);
			dataPacket.setData(data);
		}
		return dataPacket;
	}

}
